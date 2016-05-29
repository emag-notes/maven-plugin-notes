package com.example.sample.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

@Mojo(
    name = "sample",
    threadSafe = true,
    defaultPhase = LifecyclePhase.COMPILE
)
public class SampleMojo extends AbstractMojo {

  @Parameter(
      property = "project.build.directory",
      required = true
  )
  private File outputDirectory;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    if (outputDirectory == null) {
      throw new MojoExecutionException("outputDirectory is required");
    }

    getLog().info("sample plugin start!");
    getLog().debug("outputDirectory is " + outputDirectory.getAbsolutePath());
  }

}
