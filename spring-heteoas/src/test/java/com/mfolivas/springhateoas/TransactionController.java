package com.mfolivas.springhateoas;

/**
 * Controller for all the transactions.
 */

import com.mfolivas.springhateoas.domain.TransactionRequest;
import com.mfolivas.springhateoas.domain.TransactionType;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction", consumes = {"application/vnd.3ci-mercury-v1+json",
                                                    MediaType.APPLICATION_JSON_VALUE})
public class TransactionController {

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  @ResponseBody
  public String createTransaction(@Valid @RequestBody TransactionRequest transactionRequest)
      throws Exception {

    return null;
  }

  @RequestMapping(value = "/{transactionId}", method = RequestMethod.PUT)
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  @ResponseBody
  public String purchase(@PathVariable String transactionId, @RequestBody TransactionType transactionType) {
    return null;
  }
}
