package com.notfication.repo;

import com.notfication.model.FormattedNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("finalRepo")
public interface FormattedNotificationFunctions extends JpaRepository<FormattedNotification,Integer> {

}
