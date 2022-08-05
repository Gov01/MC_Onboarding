package com.onedirect.automation.MC.service;

import com.onedirect.automation.MC.model.MCModel;
import com.onedirect.automation.MC.repository.MCRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class MCService implements MCRepo {

}