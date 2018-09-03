package Spring;
import WorkWithOrders.Orders;
import WorkWithThreads.AutoGeneratOrders;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {

    final static Logger logger = Logger.getLogger(Controller.class);


    @RequestMapping("/")
    public Object greeting(@RequestParam(value = "command", required = false) String command,/*
                           @RequestParam(value = "card_id", required = false) String card_id,*/
                           @RequestParam(value = "order_id", required = false) String order_id) throws Exception {


        if (command.equals( "readall" )) {
            return readall();
        } else {
            if (command.equals( "readById" )) {
                if (order_id == null ) {
                    compute( 3 );
                    logger.error( "Нет параметра order_id!" );
                    return "Нет параметра order_id!";
                } else {
                    return readByID( order_id );
                }
            } else {
                if (command.equals( "addToCard" )) {
                        return addToCard();
                } else {
                    if (command.equals( "delById" )) {
                        if (order_id == null ) {
                            compute( 3 );
                            logger.error( "Нет параметра order_id!" );
                            return "Нет параметра order_id!";
                        } else {
                            return delById( order_id );
                        }
                    } else {
                        compute( 3 );
                        logger.error( String.format( "%s - Не правельно введена команда!", command ) );
                        return String.format( "%s - Не правельно введена команда!", command );
                    }
                }
            }
        }
    }

    private static Object readall() {
        logger.info( String.format( "Произведен вывод %s заказов", Application.orders.link.size() ));
        return Application.orders.link;
    }

    private static Object readByID(String order_id) throws InterruptedException {
        for (int ind = 0; ind < Application.orders.link.size(); ind++) {
            String idOrder = String.valueOf(Application.orders.link.get( ind ).id );
            if (order_id.equals( idOrder ) ) {
                logger.info("Произведен вывод заказа:\t" + order_id);
                return Application.orders.link.get( ind ).basketOrder;
            }
        }
        compute(1);
        logger.error( String.format( "Заказ с id - %s не найден!", order_id ) );
        return String.format( "Заказ с id - %s не найден!", order_id );
    }

    private static Object addToCard() throws InterruptedException {
        generateOrder();
        Thread.sleep( 1000 );
        logger.info("Заказ сгенерирован:\t" + Application.orders.link.get( Application.orders.link.size() - 1 ).id);
        return Application.orders.link.get( Application.orders.link.size() - 1 ).id;
    }

    private static Object delById(String order_id) throws InterruptedException {
        for (int ind = 0; ind < Application.orders.link.size(); ind++) {
            String idOrder = String.valueOf(Application.orders.link.get( ind ).id );
            if (order_id.equals( idOrder ) ) {
                Application.orders.link.remove( ind );
                logger.info(String.format( "Заказ с id - %s успешно удален!", order_id ));
                return String.format( "Заказ с id - %s успешно удален!", order_id );
            }
        }
        compute(1);
        logger.error( String.format( "Заказ с id - %s не найден!", order_id ) );
        return String.format( "Заказ с id - %s не найден!", order_id );
    }
    private static void generateOrder() {
        AutoGeneratOrders obj;
        obj = new AutoGeneratOrders( Application.orders, Application.mass, Application.user1 );
        Thread threadOrder = new Thread( obj );
        threadOrder.start();
    }

    static void compute(int kod) throws InterruptedException {
        try {
            if (kod == 1) {
                throw new ExceptionDelete( kod, "Нет такого заказа!" );
            } else {
                if (kod == 2) {
                    throw new ExceptionDelete( kod , "Файл поврежден!");
                } else {
                    if (kod == 3) {
                        throw new ExceptionDelete( kod, "Неправильная команда!" );
                    }
                }
            }
        } catch (ExceptionDelete e) {
            //e.printStackTrace();
            logger.error("Возникла ошибка:\t");
            Thread.sleep( 100 );
            e.exceptionMsg();

        }
    }
}
