package de.tanukihardwarestore.GatewayService.config;


import de.tanukihardwarestore.GatewayService.services.RabbitService;
import de.tanukihardwarestore.GatewayService.services.RabbitServiceImpl;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitServiceImpl rabbitService() {
        return new RabbitServiceImpl();
    }

    public static final String PRODUCT_QUEUE_NAME = "product";
    public static final String COMPONENT_QUEUE_NAME = "component";
    public static final String CURRENCY_QUEUE_NAME = "currency";
    public static final String PRICE_QUEUE_NAME = "price";

    public static final String SINGLE_COMPONENT_QUEUE = "single.component";

    public static final String SINGLE_PRODUCT_QUEUE = "single.product";
    private static class CurrencyQueueReceiverConfiguration {

        @Bean
        @Qualifier("currencyQueue")
        public Queue currency() {
            return new Queue(CURRENCY_QUEUE_NAME, false);
        }

        @Bean
        @Qualifier("currencyExchange")
        public DirectExchange currencyExchange() { return new DirectExchange(CURRENCY_QUEUE_NAME); }

        @Bean
        public Binding bindingCurrency(@Qualifier("currencyExchange") DirectExchange exchange,
                               @Qualifier("currencyQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(CURRENCY_QUEUE_NAME);
        }
    }

    private static class SingleProductQueueConfig {
        @Bean
        @Qualifier("singleProductExchange")
        public DirectExchange singleProductExchange() {
            return new DirectExchange(SINGLE_PRODUCT_QUEUE);
        }



        @Bean
        public Binding bindSingleProduct(@Qualifier("singleProductExchange") DirectExchange exchange,
                                         @Qualifier("singleProductQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(SINGLE_PRODUCT_QUEUE);
        }

        @Bean
        @Qualifier("singleProductQueue")
        public Queue singleProductQueue() {
            return new Queue(SINGLE_PRODUCT_QUEUE, false);
        }
    }

    private static class ProductQueueReceiverConfiguration {

        @Bean
        @Qualifier("productQueue")
        public Queue prodcut() {
            return new Queue(PRODUCT_QUEUE_NAME, false);
        }

        @Bean
        @Qualifier("productExchange")
        public DirectExchange productExchange() { return new DirectExchange(PRODUCT_QUEUE_NAME); }

        @Bean
        public Binding bindingProduct(@Qualifier("productExchange") DirectExchange exchange,
                               @Qualifier("productQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(PRODUCT_QUEUE_NAME);
        }
    }

    private static class ComponentQueueReceiverConfiguration {

        @Bean
        @Qualifier("componentQueue")
        public Queue component() {
            return new Queue(COMPONENT_QUEUE_NAME, false);
        }

        @Bean
        @Qualifier("componentExchange")
        public DirectExchange componentExchange() { return new DirectExchange(COMPONENT_QUEUE_NAME); }

        @Bean
        public Binding bindingComponent(@Qualifier("componentExchange") DirectExchange exchange,
                                      @Qualifier("componentQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(COMPONENT_QUEUE_NAME);
        }
    }

    private static class SingleComponentQueueReceiverConfiguration {

        @Bean
        @Qualifier("singleComponentExchange")
        public DirectExchange singleComponentExchange() {
            return new DirectExchange(SINGLE_COMPONENT_QUEUE);
        }



        @Bean
        public Binding bindSingleComponent(@Qualifier("singleComponentExchange") DirectExchange exchange,
                                           @Qualifier("singleComponentQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(SINGLE_COMPONENT_QUEUE);
        }

        @Bean
        @Qualifier("singleComponentQueue")
        public Queue singleComponentQueue() {
            return new Queue(SINGLE_COMPONENT_QUEUE, false);
        }
    }

    private static class PriceQueueReceiverConfiguration {

        @Bean
        @Qualifier("priceQueue")
        public Queue price() {
            return new Queue(PRICE_QUEUE_NAME, false);
        }

        @Bean
        @Qualifier("priceExchange")
        public DirectExchange priceExchange() { return new DirectExchange(PRICE_QUEUE_NAME); }

        @Bean
        public Binding bindingPrice(@Qualifier("priceExchange") DirectExchange exchange,
                               @Qualifier("priceQueue") Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(PRICE_QUEUE_NAME);
        }
    }
}
