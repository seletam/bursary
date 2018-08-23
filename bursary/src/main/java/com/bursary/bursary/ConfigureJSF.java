package com.bursary.bursary;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import org.apache.catalina.servlet4preview.ServletContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

import com.sun.faces.config.FacesInitializer;

@SuppressWarnings("deprecation")
@Configuration
public class ConfigureJSF {

	public ServletRegistrationBean facesServletRegistration() {
		ServletRegistrationBean servletRegistrationBean = new JsfServletRegistrationBean();

        return servletRegistrationBean;
    }

    public class JsfServletRegistrationBean extends ServletRegistrationBean {

        public JsfServletRegistrationBean() {
            super();
        }

        public void onStartup(ServletContext servletContext)
                throws ServletException {

            FacesInitializer facesInitializer = new FacesInitializer();

            Set<Class<?>> clazz = new HashSet<Class<?>>();
            clazz.add(ConfigureJSF.class);
            facesInitializer.onStartup(clazz, servletContext);
        }
    }
}
