package com.mfolivas.springhateoas.domain;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Transaction request from client.
 */
public class TransactionRequest {

  @NotNull
  private String clientTransactionId;

  @NotEmpty
  private String phoneNumber;

  @NotEmpty
  private String countryCode;

  public TransactionRequest(String clientTransactionId, String phoneNumber,
                            String countryCode) {
    this.clientTransactionId = clientTransactionId;
    this.phoneNumber = phoneNumber;
    this.countryCode = countryCode;
  }

  public String getClientTransactionId() {
    return clientTransactionId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getCountryCode() {
    return countryCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TransactionRequest that = (TransactionRequest) o;

    if (clientTransactionId != null ? !clientTransactionId.equals(that.clientTransactionId)
                                    : that.clientTransactionId != null) {
      return false;
    }
    if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) {
      return false;
    }
    if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = clientTransactionId != null ? clientTransactionId.hashCode() : 0;
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TransactionRequest{" +
           "clientTransactionId='" + clientTransactionId + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           ", countryCode='" + countryCode + '\'' +
           '}';
  }
}
