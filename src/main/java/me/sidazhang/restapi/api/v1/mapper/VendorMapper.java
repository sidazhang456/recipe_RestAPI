package me.sidazhang.restapi.api.v1.mapper;

import me.sidazhang.restapi.api.v1.DTO.VendorDTO;
import me.sidazhang.restapi.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO VendorToVendorDTO(Vendor vendor);
    Vendor VendorDTOToVendor(VendorDTO vendorDTO);
}
