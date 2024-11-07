package me.amiralles.category.config;

import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import me.amiralles.category.interceptor.GrpcClientRequestInterceptor;
import me.amiralles.category.interceptor.GrpcClientResponseInterceptor;
import me.amiralles.category.interceptor.GrpcServerRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

  @Bean
  public ManagedChannel managedChannel() {
    return ManagedChannelBuilder
            .forAddress(applicationProperties().getHost(),
                        applicationProperties().getPort())
            .usePlaintext()
            .build();
  }

  @Bean
  public ApplicationProperties applicationProperties() {
    return new ApplicationProperties();
  }
}
