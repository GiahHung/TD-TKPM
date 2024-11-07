package com.example.usecase.getAllCode;

import java.util.List;

import com.example.entity.AllCode;

public interface GetAllCodeDataBoundary {
List<AllCode> getAllCodes(String type);
}
