package com.zubisoft.noterecorder.viewmodels;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.zubisoft.noterecorder.data.Category;
import com.zubisoft.noterecorder.repository.DatabaseRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {

    DatabaseRepository databaseRepository;
    private  LiveData<List<Category>> categories;
    public CategoryViewModel(Application application) {
        databaseRepository=new DatabaseRepository(application);
        categories=databaseRepository.getAllCategories();
    }

    public LiveData<List<Category>> getCategories(){
        return categories;
    }

    public void addCategory(Category category){
        databaseRepository.addCategory(category);
    }
}