package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import negocio.Livraria;

@WebListener
public class LivrariaContextListener implements ServletContextListener{

	public static final String SISTEMA_LIVRARIA= "sistemaLivraria";

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();

        try {
            Livraria Livraria = new Livraria();
            context.setAttribute(SISTEMA_LIVRARIA, Livraria);
        } catch (Exception ex) {
            System.out.println("O sistema de Livraria não pode ser publicado no contexto: " + ex.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext context = event.getServletContext();

        Livraria Livraria = (Livraria) context.getAttribute(SISTEMA_LIVRARIA);

        if (Livraria != null) {
            Livraria.fechar();
        }

        context.removeAttribute(SISTEMA_LIVRARIA);
     }
	
}
