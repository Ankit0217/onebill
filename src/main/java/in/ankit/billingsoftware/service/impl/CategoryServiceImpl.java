package in.ankit.billingsoftware.service.impl;


import in.ankit.billingsoftware.entity.CategoryEntity;
import in.ankit.billingsoftware.io.CategoryRequest;
import in.ankit.billingsoftware.io.CategoryResponse;
import in.ankit.billingsoftware.repository.CategoryRepository;
import in.ankit.billingsoftware.repository.ItemRepository;
import in.ankit.billingsoftware.service.CategoryService;
import in.ankit.billingsoftware.service.FileUploadService;
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
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final FileUploadService fileUploadService;
    private final ItemRepository itemRepository;

    @Override
    public CategoryResponse add(CategoryRequest request, MultipartFile file) throws IOException {
        String imgUrl = fileUploadService.uploadFile(file);
        CategoryEntity newCategory = convertToEntity(request);
        newCategory.setImgUrl(imgUrl);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    @Override
    public List<CategoryResponse> read() {
        return categoryRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId) {
        CategoryEntity existingCategory = categoryRepository.findByCategoryId(categoryId)
                .orElseThrow(() -> new RuntimeException("Category Not Found:" + categoryId));
        String imgUrl = existingCategory.getImgUrl();
        String fileName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
        Path uploadPath = Paths.get("uploads").toAbsolutePath().normalize();
        Path filePath = uploadPath.resolve(fileName);
        System.out.println("Trying to delete file at: " + filePath.toString());

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryRepository.delete(existingCategory);
    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
        Integer itemCount = itemRepository.countByCategoryId(newCategory.getId());
        return CategoryResponse.builder()
                .categoryId(newCategory.getCategoryId())
                .name(newCategory.getName())
                .description(newCategory.getDescription())
                .bgColor(newCategory.getBgColor())
                .imgUrl(newCategory.getImgUrl())
                .createdAt(newCategory.getCreatedAt())
                .updatedAt(newCategory.getUpdatedAt())
                .items(itemCount)
                .build();
    }

    private CategoryEntity convertToEntity(CategoryRequest request) {
        return CategoryEntity.builder()
                .categoryId(UUID.randomUUID().toString())
                .name(request.getName())
                .description(request.getDescription())
                .bgColor(request.getBgColor())
                .build();
    }


}

