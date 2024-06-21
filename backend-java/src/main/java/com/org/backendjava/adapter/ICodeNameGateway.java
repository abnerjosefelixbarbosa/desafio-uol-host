package com.org.backendjava.adapter;

import com.org.backendjava.infra.enums.GroupTypeDB;

public interface ICodeNameGateway {
	String getCodenameByGroupType(GroupTypeDB type);
}