package org.apache.nifi.c2.mockserver.controller;

import org.apache.nifi.c2.protocol.api.C2OperationAck;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acknowledge")
public class AcknowledgeController {

  @PostMapping
  public ResponseEntity<Void> handleHeartbeat(@RequestBody C2OperationAck acknowledge) {
    // Log or process the input C2OperationAck object (if needed)
    System.out.println("Received Acknowledgement: " + acknowledge);

    return ResponseEntity.ok().build();
  }
}
