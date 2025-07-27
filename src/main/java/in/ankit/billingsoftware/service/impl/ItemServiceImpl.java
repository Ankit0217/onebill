package in.ankit.billingsoftware.service.impl;


import in.ankit.billingsoftware.entity.CategoryEntity;
import in.ankit.billingsoftware.entity.ItemEntity;
import in.ankit.billingsoftware.io.ItemRequest;
import in.ankit.billingsoftware.io.ItemResponse;
import in.ankit.billingsoftware.repository.CategoryRepository;
import in.ankit.billingsoftware.repository.ItemRepository;
import in.ankit.billingsoftware.service.FileUploadService;
import in.ankit.billingsoftware.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final FileUploadService fileUploadService;
    private final CategoryRepository categoryRepository;

    @Override
    public ItemResponse add(ItemRequest request, MultipartFile file) throws IOException {
        String imgUrl = fileUploadService.uploadFile(file);
        ItemEntity newItem = convertToEntity(request);
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found: " + request.getCategoryId()));
        newItem.setCategory(existingCategory);
        newItem.setImgUrl(imgUrl);
        newItem = itemRepository.save(newItem);
        return convertToResponse(newItem);
    }

    private ItemResponse convertToResponse(ItemEntity newItem) {
        return ItemResponse.builder()
                .itemId(newItem.getItemId())
                .name(newItem.getName())
                .description(newItem.getDescription())
                .price(newItem.getPrice())
                .imgUrl(newItem.getImgUrl())
                .categoryName(newItem.getCategory().getName())
                .categoryId(newItem.getCategory().getCategoryId())
                .createdAt(newItem.getCreatedAt())
                .updatedAt(newItem.getUpdatedAt())
                .build();
    }

    private ItemEntity convertToEntity(ItemRequest request) {
        return ItemEntity.builder()
                .itemId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }


    @Override
    public List<ItemResponse> fetchItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemEntity -> convertToResponse(itemEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteItem(String itemId) {
        ItemEntity existingItem = itemRepository.findByItemId(itemId)
                .orElseThrow(() -> new RuntimeException("Item Not Found:" + itemId));
        String imgUrl = existingItem.getImgUrl();
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
        Path uploadPath = Paths.get("uploads").toAbsolutePath().normalize();
        Path filePath = uploadPath.resolve(fileName);

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemRepository.delete(existingItem);
    }
}

