package com.project;

public interface DataConnect {
    void insertRow(User user);
    void updateRow(User user);
    void deleteRow(User user);
    Object retrieveRecord(String username);

}
