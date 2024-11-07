package com.example.usecase.getAllCode;

import java.util.List;

import com.example.entity.AllCode;

public interface GetAllCodeOutputBoundary {
void presentCategory(List<AllCode> category);
void presentDVT(List<AllCode> dvt);
}
