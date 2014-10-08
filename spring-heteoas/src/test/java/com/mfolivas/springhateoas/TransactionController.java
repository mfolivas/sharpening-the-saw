package com.mfolivas.springhateoas;

/**
 * Controller for all the transactions.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction", produces = "application/vnd.3ci-mercury-v1+json")
public class TransactionController {


  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  @ResponseBody
  public String createTransaction()
      throws Exception {

    return null;
  }




}
