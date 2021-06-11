/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;

/**
 * abstract class controller 
 */
public abstract class DataController<T> {
    public abstract List<T> getList();
    
    public abstract T getOne(int id);
    
    public abstract  void insert(T obj);
    
    public abstract void delete(int id);
    
    public abstract void update(int id, T obj);
    
    public abstract List<T> find(String param);
    
}
