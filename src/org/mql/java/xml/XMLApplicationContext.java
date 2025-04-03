package org.mql.java.xml;

import org.mql.java.annotations.Data;
import org.mql.java.services.AbstractApplicationContext;

@Data(source="resources/beans.xml")
public class XMLApplicationContext extends AbstractApplicationContext {

    @Override
    public void load() {
    	XMLContextLoader loader = new XMLContextLoader(this,(name,bean)->addBean(name, bean));
        loader.start();
        try {
			loader.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}