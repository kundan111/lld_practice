package io.binactivate.service;

import io.binactivate.model.ExpenseGroup;
import io.binactivate.model.User;

public interface NotificationService {
    void notifyUser(User user, ExpenseGroup expenseGroup);
}
