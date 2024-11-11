package com.asaas.docs.service.subscription;

import com.asaas.docs.dto.request.ConfigurationIssuingInvoicesRequestDTO;
import com.asaas.docs.dto.request.ConfigurationUpdateIssuingInvoicesRequestDTO;
import com.asaas.docs.dto.request.SubscriptionRequestDTO;
import com.asaas.docs.dto.request.SubscriptionUpdateRequestDTO;
import com.asaas.docs.dto.response.*;
import com.asaas.docs.enums.BillingType;
import com.asaas.docs.enums.InvoiceStatus;
import com.asaas.docs.enums.PaymentStatus;
import com.asaas.docs.enums.SubscriptionStatus;
import lombok.NonNull;

public interface SubscriptionService {

    SubscriptionResponseDTO createSubscription(@NonNull SubscriptionRequestDTO request);

    SubscriptionsListResponseDTO subscriptionsList(Integer offset, Integer limit, String customer,
                                                   String customerGroupName, BillingType billingType,
                                                   SubscriptionStatus status, Boolean deletedOnly,
                                                   Boolean includeDeleted, String externalReference, String order,
                                                   String sort);

    SubscriptionResponseDTO getSubscription(@NonNull String id);

    SubscriptionResponseDTO updateSubscription(@NonNull String id, @NonNull SubscriptionUpdateRequestDTO request);

    DeleteResponseDTO deleteSubscription(@NonNull String id);

    PaymentsListResponseDTO paymentsListOfASubscription(@NonNull String id, PaymentStatus status);

    String generateSubscriptionBooklet(@NonNull String id, @NonNull Integer month, @NonNull Integer year, String sort, String order);

    ConfigurationIssuingInvoicesResponseDTO createConfigurationForIssuingInvoice(@NonNull String id,
                                                                                 @NonNull ConfigurationIssuingInvoicesRequestDTO request);

    ConfigurationIssuingInvoicesResponseDTO getConfigurationForIssuingInvoice(@NonNull String id);

    DeleteResponseDTO deleteConfigurationForIssuingInvoice(@NonNull String id);

    ConfigurationIssuingInvoicesResponseDTO updateConfigurationForIssuingInvoice(@NonNull String id,
                                                                                 @NonNull ConfigurationUpdateIssuingInvoicesRequestDTO request);

    InvoicesListResponseDTO invoicesForSubscriptionList(@NonNull String id, Integer offset, Integer limit,
                                                        String effectiveDateGe,
                                                        String effectiveDateLe, String externalReference,
                                                        InvoiceStatus status, String customer);

}
