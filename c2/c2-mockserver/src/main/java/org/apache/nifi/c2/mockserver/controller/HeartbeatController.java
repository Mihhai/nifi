package org.apache.nifi.c2.mockserver.controller;

import org.apache.nifi.c2.protocol.api.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@RestController
@RequestMapping("/heartbeat")
public class HeartbeatController {
  static int opCounter = 0;
  static int callCounter = 0;
  static boolean lastOpStart = false;

  @PostMapping
  public ResponseEntity<C2HeartbeatResponse> handleHeartbeat(@RequestBody C2Heartbeat heartbeat) {
    System.out.println("Received Heartbeat: " + heartbeat);

    C2HeartbeatResponse heartbeatResponse = new C2HeartbeatResponse();

    if (callCounter % 10 == 0) {
      C2Operation c2Operation = new C2Operation();
      c2Operation.setIdentifier("op-" + opCounter);

      if (!lastOpStart) {
        c2Operation.setOperation(OperationType.START);
        System.out.println("Sending start ...");
        lastOpStart = true;
      }
      else {
        c2Operation.setOperation(OperationType.STOP);
        System.out.println("Sending stop ...");
        lastOpStart = false;
      }

      c2Operation.setOperand(OperandType.FLOW);
      heartbeatResponse.setRequestedOperations(Collections.singletonList(c2Operation));
      opCounter++;
    }

    callCounter++;
    return ResponseEntity.ok(heartbeatResponse);
  }
}
