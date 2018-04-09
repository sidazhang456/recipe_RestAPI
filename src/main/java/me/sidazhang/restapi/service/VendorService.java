package me.sidazhang.restapi.service;

import me.sidazhang.restapi.api.v1.DTO.VendorDTO;
import me.sidazhang.restapi.api.v1.DTO.VendorListDTO;

import java.util.List;

public interface VendorService {
    VendorDTO getVendorById(Long id);

    List<VendorDTO> getAllVendors();

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);

    void deleteVendorById(Long id);
}
