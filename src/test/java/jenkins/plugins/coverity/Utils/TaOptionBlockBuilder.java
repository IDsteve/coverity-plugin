/*******************************************************************************
 * Copyright (c) 2017 Synopsys, Inc
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Synopsys, Inc - initial implementation and documentation
 *******************************************************************************/
package jenkins.plugins.coverity.Utils;

import jenkins.plugins.coverity.TaOptionBlock;

public class TaOptionBlockBuilder {

    private String customTestCommand;
    private boolean cOptionBlock;
    private boolean csOptionBlock;
    private String scmSystem;
    private String customTestTool;
    private String scmToolArguments;
    private String scmCommandArgs;
    private String logFileLoc;
    private String csFramework;
    private String csCoverageTool;
    private String cxxCoverageTool;
    private String javaCoverageTool;
    private boolean junitFramework;
    private boolean junit4Framework;
    private boolean scmOptionBlock;
    private String policyFile;
    private String taStripPath;
    private String p4Port;
    private String accRevRepo;
    private String bullsEyeDir;
    private String customWorkDir;
    private boolean covHistoryCheckbox;
    private boolean javaOptionBlock;

    public TaOptionBlockBuilder withCustomTestCommand(String customTestCommand) {
        this.customTestCommand = customTestCommand;
        return this;
    }

    public TaOptionBlockBuilder withCoptionBlock(boolean cOptionBlock) {
        this.cOptionBlock = cOptionBlock;
        return this;
    }

    public TaOptionBlockBuilder withCsOptionBlock(boolean csOptionBlock) {
        this.csOptionBlock = csOptionBlock;
        return this;
    }

    public TaOptionBlockBuilder withScmSystem(String scmSystem) {
        this.scmSystem = scmSystem;
        return this;
    }

    public TaOptionBlockBuilder withCustomTestTool(String customTestTool) {
        this.customTestTool = customTestTool;
        return this;
    }

    public TaOptionBlockBuilder withScmToolArguments(String scmToolArguments) {
        this.scmToolArguments = scmToolArguments;
        return this;
    }

    public TaOptionBlockBuilder withScmCommandArgs(String scmCommandArgs) {
        this.scmCommandArgs = scmCommandArgs;
        return this;
    }

    public TaOptionBlockBuilder withLogFileLoc(String logFileLoc) {
        this.logFileLoc = logFileLoc;
        return this;
    }

    public TaOptionBlockBuilder withCsFramework(String csFramework) {
        this.csFramework = csFramework;
        return this;
    }

    public TaOptionBlockBuilder withCsCoverageTool(String csCoverageTool) {
        this.csCoverageTool = csCoverageTool;
        return this;
    }

    public TaOptionBlockBuilder withCxxCoverageTool(String cxxCoverageTool) {
        this.cxxCoverageTool = cxxCoverageTool;
        return this;
    }

    public TaOptionBlockBuilder withJavaCoverageTool(String javaCoverageTool) {
        this.javaCoverageTool = javaCoverageTool;
        return this;
    }

    public TaOptionBlockBuilder withJunitFramework(boolean junitFramework) {
        this.junitFramework = junitFramework;
        return this;
    }

    public TaOptionBlockBuilder withJunit4Framework(boolean junit4Framework) {
        this.junit4Framework = junit4Framework;
        return this;
    }

    public TaOptionBlockBuilder withScmOptionBlock(boolean scmOptionBlock) {
        this.scmOptionBlock = scmOptionBlock;
        return this;
    }

    public TaOptionBlockBuilder withPolicyFile(String policyFile) {
        this.policyFile = policyFile;
        return this;
    }

    public TaOptionBlockBuilder withStripPath(String stripPath) {
        this.taStripPath = stripPath;
        return this;
    }

    public TaOptionBlockBuilder withP4Port(String p4Port) {
        this.p4Port = p4Port;
        return this;
    }

    public TaOptionBlockBuilder withAccrevRepo(String accRevRepo) {
        this.accRevRepo = accRevRepo;
        return this;
    }

    public TaOptionBlockBuilder withBullsEyeDir(String bullsEyeDir) {
        this.bullsEyeDir = bullsEyeDir;
        return this;
    }

    public TaOptionBlockBuilder withCustomWorkDir(String customWorkDir) {
        this.customWorkDir = customWorkDir;
        return this;
    }

    public TaOptionBlockBuilder withCovHistoryCheckBox(boolean covHistoryCheckBox) {
        this.covHistoryCheckbox = covHistoryCheckBox;
        return this;
    }

    public TaOptionBlockBuilder withJavaOptionBlock(boolean javaOptionBlock) {
        this.javaOptionBlock = javaOptionBlock;
        return this;
    }

    public TaOptionBlock build() {
        return new TaOptionBlock(
                customTestCommand,
                cOptionBlock,
                csOptionBlock,
                javaOptionBlock,
                scmSystem,
                customTestTool,
                scmToolArguments,
                scmCommandArgs,
                logFileLoc,
                csFramework,
                csCoverageTool,
                cxxCoverageTool,
                javaCoverageTool,
                junitFramework,
                junit4Framework,
                scmOptionBlock,
                policyFile,
                taStripPath,
                p4Port,
                accRevRepo,
                bullsEyeDir,
                customWorkDir,
                covHistoryCheckbox);
    }
}