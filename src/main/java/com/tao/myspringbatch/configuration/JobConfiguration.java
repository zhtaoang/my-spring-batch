package com.tao.myspringbatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Tao Zhang on 5/28/18
 */
@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("\n\n\n\nhello world 1\n\n\n\n");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("\n\n\n\nhello world 2\n\n\n\n");
                    return RepeatStatus.FINISHED;
                }).build();
    }


    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("\n\n\n\nhello world 3\n\n\n\n");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Flow flow12() {
        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow12");
        flowBuilder.start(step1()).next(step2()).end();
        return flowBuilder.build();
    }


    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .start(flow12())
                .next(step3())
                .end()
                .build();
    }

}
