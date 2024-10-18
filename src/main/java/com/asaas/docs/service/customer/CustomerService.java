package com.asaas.docs.service.customer;

import com.asaas.docs.dto.request.CustomerRequestDTO;
import com.asaas.docs.dto.response.CustomerListResponseDTO;
import com.asaas.docs.dto.response.CustomerResponseDTO;
import com.asaas.docs.dto.response.DeleteResponseDTO;
import com.asaas.docs.dto.response.NotificationsListResponseDTO;
import lombok.NonNull;

public interface CustomerService {

    CustomerResponseDTO createCustomer(@NonNull CustomerRequestDTO request);

    CustomerListResponseDTO customerList(Integer offset, Integer limit, String name, String email,
                                         String cpfCnpj, String groupName, String externalReference);

    CustomerResponseDTO getCustomer(@NonNull String id);

    CustomerResponseDTO updateCustomer(@NonNull String id, @NonNull CustomerRequestDTO request);

    DeleteResponseDTO deleteCustomer(@NonNull String id);

    CustomerResponseDTO restoreCustomer(@NonNull String id);

    NotificationsListResponseDTO notificationListCustomer(@NonNull String id);

}
