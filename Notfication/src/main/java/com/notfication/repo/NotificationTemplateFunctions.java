package com.notfication.repo;

import com.notfication.model.NotificationTemplate;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("repo")
public interface NotificationTemplateFunctions extends JpaRepository<NotificationTemplate,Integer> {

}
/*
	public void addTemplate(NotificationTemplate template);
	public void deleteTemplate(int templateID);
	public void updateTemplate(NotificationTemplate template);
	public NotificationTemplate getTemplate(int templateId);
	public List<NotificationTemplate> getAll();*/