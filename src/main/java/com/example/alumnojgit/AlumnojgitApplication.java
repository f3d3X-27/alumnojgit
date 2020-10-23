package com.example.alumnojgit;

import com.example.alumnojgit.gitcontrol.GitControl;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AlumnojgitApplication {

	public static void main(String[] args) throws IOException, GitAPIException {

		//SpringApplication.run(AlumnojgitApplication.class, args);


		String localPath = "C:/Users/f3d3x/IdeaProjects/alumnojgit";
		String remotePath = "https://github.com/f3d3X-27/alumnojgit.git";

		GitControl gc = new GitControl(localPath, remotePath);

		//gc.repolocal(); // 1- Metodo utilizado
		gc.addToRepo();

		//gc.createNewBranch("development"); //2- Metodo utilizado




		//Clone repository
		//gc.cloneRepo();

		//Add files to repository
		// * gc.addToRepo();

		//Commit with a custom message
		// * gc.commitToRepo("Added C3 and method.");

		//Push commits
		// * gc.pushToRepo();

		//Pull
		//pull (modifica local) = fetch (no modifica local) + commit
		// * gc.pullFromRepo();

		//Create new branch
		// * gc.createNewBranch("ramaNueva");

		//Checkout to specific branch
		// * gc.checkout("ramaNueva");
	}

}








