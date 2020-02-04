package com.saberhamza.entity;

import java.util.List;

/**
 * Collection of repositories.
 * 
 * @author Hamza SABER
 *
 */
public class RepositoryCollections {
	
	/**
	 * Total number of repositories.
	 */
	private int reposCount;
	
	/**
	 * List of repositories.
	 */
	private List<Repository> repositories;

	/**
	 * no-args constructor.
	 */
	public RepositoryCollections() {
	}

	/**
	 * Constructor for RepositoryCollections class.
	 * 
	 * @param reposCount Total number of repositories.
	 * @param repositories List of repositories.
	 */
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