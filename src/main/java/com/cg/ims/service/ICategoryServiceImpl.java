package com.cg.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ims.dto.CategoryDTO;
import com.cg.ims.exception.CategoryException;
import com.cg.ims.repository.ICategoryRepository;

@Service
public class ICategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public CategoryDTO addCategory(CategoryDTO category) throws CategoryException
	{
		if(categoryRepository.existsById(category.getCatId()))
		{
			throw new CategoryException("Category Id already exist");
		}
		else
		{
			categoryRepository.save(category);
			return category;
		}
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO category) throws CategoryException
	{
		if(categoryRepository.existsById(category.getCatId()))
		{
			categoryRepository.save(category);
			return category;
		}
		else
		{
			throw new CategoryException("Category Id not found");
		}
	}

	@Override
	public CategoryDTO deleteCategory(Integer id) throws CategoryException {
		if(categoryRepository.existsById(id))
		{
			CategoryDTO category=categoryRepository.findById(id).get();
			categoryRepository.delete(category);
			return category;
		}
		else
		{
			throw new CategoryException("Category Id not found");
		}
	}

	@Override
	public CategoryDTO getCategoryById(Integer id) throws CategoryException {
		if(categoryRepository.existsById(id))
		{
			return categoryRepository.findById(id).get();
		}
		else
		{
			throw new CategoryException("Category Id not found");
		}
	}

	@Override
	public List<CategoryDTO> getAllCategories() {
		List<CategoryDTO> list=categoryRepository.findAll();
		return list;
		
	}

}

