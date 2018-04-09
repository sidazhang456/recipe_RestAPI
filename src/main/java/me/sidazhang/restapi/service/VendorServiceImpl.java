package me.sidazhang.restapi.service;

import me.sidazhang.restapi.api.v1.DTO.VendorDTO;
import me.sidazhang.restapi.api.v1.DTO.VendorListDTO;
import me.sidazhang.restapi.api.v1.mapper.VendorMapper;
import me.sidazhang.restapi.model.Vendor;
import me.sidazhang.restapi.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {
    private static final String BASE_URL = "/api/v1/vendor/";
    private VendorRepository vendorRepository;
    private VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        Optional<Vendor> vendor = vendorRepository.findById(id);
        if(!vendor.isPresent()){throw new ResourceNotFoundException();}
        VendorDTO vendorDTO=vendorMapper.VendorToVendorDTO(vendor.get());
        vendorDTO.setUrl(BASE_URL+id);
        return vendorDTO;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream().map(
                vendor -> {VendorDTO vendorDTO=vendorMapper.VendorToVendorDTO(vendor);
                vendorDTO.setUrl(BASE_URL+vendor.getId());
                return vendorDTO;}
        ).collect(Collectors.toList());
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendorToSave = vendorMapper.VendorDTOToVendor(vendorDTO);
        VendorDTO retVendorDTO = saveAndSetUrl(vendorToSave);
        return retVendorDTO;
    }

    private VendorDTO saveAndSetUrl(Vendor vendorToSave) {
        Vendor savedVendor = vendorRepository.save(vendorToSave);
        VendorDTO retVendorDTO = vendorMapper.VendorToVendorDTO(savedVendor);
        retVendorDTO.setUrl(BASE_URL+vendorToSave.getId());
        return retVendorDTO;
    }

    @Override
    public VendorDTO saveVendorByDTO(Long id, VendorDTO vendorDTO) {
        Vendor vendorToSave = vendorMapper.VendorDTOToVendor(vendorDTO);
        vendorToSave.setId(id);
        return saveAndSetUrl(vendorToSave);
    }


    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public void deleteVendorById(Long id) {
        if(!vendorRepository.findById(id).isPresent()){throw new ResourceNotFoundException();}
        vendorRepository.deleteById(id);
    }
}
