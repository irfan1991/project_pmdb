package com.projectpmdb.service;

import java.util.List;

import com.projectpmdb.model.SupplierModel;

public interface SupplierService {
	
List<SupplierModel> selectAllSupplier();
void addSupplier(SupplierModel supplierModel);
void deleteSupplier(int id);
SupplierModel getView(int id);
SupplierModel getEdit(int id);
void updateSupplier(SupplierModel supplierModel);
List<SupplierModel> getCountSupplier();
List<SupplierModel> cariSupplier(String cari);

}
