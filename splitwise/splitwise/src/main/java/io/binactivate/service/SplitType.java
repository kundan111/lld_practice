package io.binactivate.service;

import io.binactivate.exception.IllegalExactSplitGiven;
import io.binactivate.exception.IllegalPercentSplitGiven;
import io.binactivate.model.User;

public interface SplitType {

    double getPart(User user) throws IllegalExactSplitGiven, IllegalPercentSplitGiven ;
}
