#git commands

##configure before first time to use git

* `git config --global user.name "waitingliu"`
* `git config --global user.email baby@example.com`

current user`s git configurations in `~/.gitconfig` file

##create repo

```
mkdir reponame
cd reponame
git init
```
##clone repo

* local-repo `git clone /path/to/repo`
* remote-repo `git clone username@host:/path/to/repo`

for example: `git clone git@github.com:waitingliu/citrus.git`

##git working command

The local repo consists of 3 trees:

* working dir(工作目录)
* stage (暂存区)
* HEAD(last commit to master)
----
1. `git add <filename>` or `git add .`  -add to stage
2. `git commmit -m "commit info"`  -commit to HEAD
3. `git push origin master` or simply as `git push` -push to remote repo
*link the local-repo to the remote-repo using `git remote add origin <server>`,and then you can simply use `git push` and `git pull` to work.*

##branch

* `git checkout -b branch_name` -create a new branch and switch to it.
* `git checkout master`  -switch to master.
* `git branch -d branch_name` -delete a branch.
* `git push origin <branch>` -push the branch to remote-repo.

##update and merge

* `git pull`  -fetch + auto-merge
* `git fetch` 
* `git merge <branch>`
* 



