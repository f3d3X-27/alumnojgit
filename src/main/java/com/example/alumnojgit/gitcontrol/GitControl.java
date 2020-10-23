package com.example.alumnojgit.gitcontrol;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.*;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

public class GitControl {

    private String localPath, remotePath;
    private Repository localRepo;
    private Git git;
    private CredentialsProvider cp;
    private String name = "fmasnuprogram@gmail.com";
    private String password = "fedex2797";

    public GitControl(String localPath, String remotePath) throws IOException {
        this.localPath = localPath;
        this.remotePath = remotePath;
        this.localRepo = new FileRepository(localPath + "/.git");
        cp = new UsernamePasswordCredentialsProvider(this.name, this.password);
        git = new Git(localRepo);
    }


    public void cloneRepo() throws IOException, NoFilepatternException, GitAPIException {
        Git.cloneRepository()
                .setURI(remotePath)
                .setDirectory(new File(localPath))
                .call();
    }

    public void addToRepo() throws IOException, NoFilepatternException, GitAPIException {
        AddCommand add = git.add();
        add.addFilepattern(".").call();
    }

    public void commitToRepo(String message) throws IOException, NoHeadException,
            NoMessageException, ConcurrentRefUpdateException,
            JGitInternalException, WrongRepositoryStateException, GitAPIException {
        git.commit().setMessage(message).call();
    }

    public void pushToRepo() throws IOException, JGitInternalException,
            InvalidRemoteException, GitAPIException {
        PushCommand pc = git.push();
        pc.setCredentialsProvider(cp)
                .setForce(true)
                .setPushAll();
        try {
            Iterator<PushResult> it = pc.call().iterator();
            if (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        } catch (InvalidRemoteException e) {
            e.printStackTrace();
        }
    }

    public void pullFromRepo() throws IOException, WrongRepositoryStateException,
            InvalidConfigurationException, DetachedHeadException,
            InvalidRemoteException, CanceledException, RefNotFoundException,
            NoHeadException, GitAPIException {
        git.pull().call();
    }

    public void createNewBranch(String branchName) throws IOException, GitAPIException {
        git.checkout()
                .setCreateBranch(true)
                .setName(branchName)
                .call();
        System.out.println("New branch created: " + branchName);
    }

    public void checkout(String branchName) throws IOException, GitAPIException {
        git.checkout()
                .setCreateBranch(false)
                .setName(branchName)
                .call();
        System.out.println("You are in branch: " + branchName);
    }

    public void repolocal() throws IOException, GitAPIException {
        git = Git.init().setDirectory(new File("C:/Users/f3d3x/IdeaProjects/alumnojgit")).call();
    }

    public void remoteAddOrigin(String remotePath) throws URISyntaxException, GitAPIException {
        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("origin");
        remoteAddCommand.setUri(new URIish(remotePath));
        remoteAddCommand.call();
        System.out.println("Repositorio local con remoto sincronizado");
    }

}
