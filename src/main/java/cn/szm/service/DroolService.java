package cn.szm.service;

import cn.szm.entity.DataValue;
import cn.szm.entity.Person;
import org.kie.api.KieBase;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lw-yf-018 on 2017/3/15.
 */
@Service
public class DroolService {

	@KSession("my_kSession")
	private KieSession mySession;//satefull类型的session
	//@KSession("lessSession")
	//private StatelessKieSession lessSession;//stateless类型的session
	@Autowired
	private KieBase kbase1;



	//kieSession测试
	public void test() {
		Person person = new Person("张三", 25, "山西");
		mySession.insert(person);
		DataValue dv=new DataValue(6.6);
		mySession.insert(dv);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("k1",1);
		map.put("k2",2);
		mySession.insert(map);
		mySession.fireAllRules();
		mySession.dispose();
		System.out.println("---执行完毕");
	}
	//用StatelessKieSession与规则引擎交互测试
	/*public void test3() {
		List<Command> list = new ArrayList<Command>();
		list.add(CommandFactory.newInsert(new Person("w5", 24, "山西")));
		list.add(CommandFactory.newInsert(new Person("w6", 24, "山西")));
		lessSession.execute(CommandFactory.newBatchExecution(list));
	}*/



}
