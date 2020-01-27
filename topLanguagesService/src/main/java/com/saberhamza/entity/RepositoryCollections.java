package com.saberhamza.entity;

import java.util.List;

public class RepositoryCollections {
	
	private int reposCount;
	
	private List<Repository> repositories;

	public RepositoryCollections() {
	}

	public RepositoryCollections(int reposCount, List<Repository> repositories) {
		this.reposCount = reposCount;
		this.repositories = repositories;
	}

	public int getReposCount() {
		return reposCount;
	}

	public void setReposCount(int reposCount) {
		this.reposCount = reposCount;
	}

	public List<Repository> getRepositories() {
		return repositories;
	}

	public void setRepositories(List<Repository> repositories) {
		this.repositories = repositories;
	}
	
}