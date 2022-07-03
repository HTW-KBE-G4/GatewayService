package de.tanukihardwarestore.GatewayService.config;

import de.tanukihardwarestore.GatewayService.rabbit.receiver.CurrencyQueueReceiver;
import de.tanukihardwarestore.GatewayService.rabbit.receiver.PriceQueueReceiver;
import de.tanukihardwarestore.GatewayService.rabbit.receiver.ProductQueueReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String PRODUCT_QUEUE_NAME = "product";
    public static final String CURRENCY_QUEUE_NAME = "currency";
    public static final String PRICE_QUEUE_NAME = "price";


    private static class CurrencyQueueReceiverConfiguration {

        @Bean
        public DirectExchange exchange() { return new DirectExchange(CURRENCY_QUEUE_NAME); }

        @Bean
        public CurrencyQueueReceiver receiver() { return new CurrencyQueueReceiver(); }

        @Bean
        public Binding binding(DirectExchange exchange,
                               Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(CURRENCY_QUEUE_NAME);
        }
    }

    private static class ProductQueueReceiverConfiguration {

        @Bean
        public DirectExchange exchange() { return new DirectExchange(PRODUCT_QUEUE_NAME); }

        @Bean
        public ProductQueueReceiver receiver() { return new ProductQueueReceiver(); }

        @Bean
        public Binding binding(DirectExchange exchange,
                               Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(PRODUCT_QUEUE_NAME);
        }
    }

    private static class PriceQueueReceiverConfiguration {

        @Bean
        public DirectExchange exchange() { return new DirectExchange(PRICE_QUEUE_NAME); }

        @Bean
        public PriceQueueReceiver receiver() { return new PriceQueueReceiver(); }

        @Bean
        public Binding binding(DirectExchange exchange,
                               Queue queue) {
            return BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(PRICE_QUEUE_NAME);
        }
    }

    @Bean
    public Queue prodcut() {
        return new Queue(PRODUCT_QUEUE_NAME, false);
    }

    @Bean
    public Queue currency() {
        return new Queue(CURRENCY_QUEUE_NAME, false);
    }

    @Bean
    public Queue price() {
        return new Queue(PRICE_QUEUE_NAME, false);
    }

}
