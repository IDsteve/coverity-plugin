/*******************************************************************************
 * Copyright (c) 2018 Synopsys, Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Synopsys, Inc - initial implementation and documentation
 *******************************************************************************/
package jenkins.plugins.coverity.CoverityTool;

import jenkins.plugins.coverity.CoverityPublisher;
import jenkins.plugins.coverity.Utils.CoverityPublisherBuilder;
import jenkins.plugins.coverity.ScmOptionBlock;
import jenkins.plugins.coverity.Utils.ScmOptionBlockBuilder;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CovImportScmCommandTest extends CommandTestBase {

    @Test
    public void prepareCommandTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addCustomTestToolTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withCustomTestTool("TestCustomTestTool").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "--tool", "TestCustomTestTool"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addScmToolArgumentsTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withScmToolArguments("TestScmToolArguments").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "--tool-arg", "TestScmToolArguments"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addScmCommandArgumentsTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withScmCommandArgs("TestScmCommandArguments").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "--command-arg", "TestScmCommandArguments"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addLogFileLocationTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withLogFileLoc("TestLogFileLocation").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "--log", "TestLogFileLocation"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addFileRegexTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withFileRegex("*.java").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "--filename-regex", "*.java"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addAccurevProjectRootTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("accurev").withAccRevRepo("TestAccurrevProjectRoot").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "accurev", "--project-root", "TestAccurrevProjectRoot"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addP4PortTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("perforce").withP4Port("1234").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "perforce"});
        covImportScmCommand.runCommand();
        assertEquals("1234", envVars.get("P4PORT"));
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addScmAdditionalCommandTest() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withScmAdditionalCmd("AdditionalCommand").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        setExpectedArguments(new String[] {"cov-import-scm", "--dir", "TestDir", "--scm", "git", "AdditionalCommand"});
        covImportScmCommand.runCommand();
        consoleLogger.verifyLastMessage("[Coverity] cov-import-scm command line arguments: " + actualArguments.toString());
    }

    @Test
    public void addScmAdditionalCommandTest_WithParseException() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("git").withScmAdditionalCmd("\'").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        try{
            covImportScmCommand.runCommand();
            fail("RuntimeException should have been thrown");
        }catch (RuntimeException e) {
            assertEquals("ParseException occurred during tokenizing the cov import scm additional command.", e.getMessage());
        }
    }

    @Test
    public void doesNotExecute_WithoutScmOptionBlock() throws IOException, InterruptedException {
        CoverityPublisher publisher = new CoverityPublisherBuilder().build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        covImportScmCommand.runCommand();
        verifyNumberOfExecutedCommands(0);
    }

    @Test
    public void doesNotExecute_WithoutScmTool() throws IOException, InterruptedException {
        ScmOptionBlock scmOptionBlock = new ScmOptionBlockBuilder().withScmSystem("none").build();
        CoverityPublisher publisher = new CoverityPublisherBuilder().withScmOptionBlock(scmOptionBlock).build();

        Command covImportScmCommand = new CovImportScmCommand(build, launcher, listener, publisher, StringUtils.EMPTY, envVars);
        covImportScmCommand.runCommand();
        verifyNumberOfExecutedCommands(0);
    }
}
