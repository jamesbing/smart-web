package com.fovoy.smart.service.wechat;

import java.util.HashMap;
import java.util.Map;

public class SmsDemo {

	/**
	 * ���Žӿ�һ����д�������ݡ��ýӿ��ύ�Ķ��ž����˹���ˣ��·�������ϵ���߿ͷ����ʺϣ��ڼ���ף������ԱӪ��Ⱥ���ȡ�
	 */
	public static void sms_api1() {

		Map<String, String> para = new HashMap<String, String>();

		/**
		 * Ŀ���ֻ����룬����ԡ�,���ָ���һ���Ե������100�����룬ʾ����139********,138********
		 */
		para.put("mob", "<enter your mobiles>");

		/**
		 * ΢���˺ŵĽӿ�UID
		 */
		para.put("uid", "<enter your UID>");

		/**
		 * ΢���˺ŵĽӿ�����
		 */
		para.put("pas", "<enter your UID Pass>");

		/**
		 * �ӿڷ������ͣ�json��xml��txt��Ĭ��ֵΪtxt
		 */
		para.put("type", "json");

		/**
		 * �������ݡ��������úö���ǩ����ǩ���淶�� <br>
		 * 1����������һ��Ҫ��ǩ����ǩ�����ڶ������ݵ���ǰ�棻<br>
		 * 2��ǩ����ʽ����***����ǩ������Ϊ�����������ϣ�������������<br>
		 * 3���������ݲ�����˫ǩ����������������ֻ��һ����������
		 * 
		 */
		para.put("con", "��΢�ס�������֤���ǣ�610912��3��������Ч����������˲������ɺ��Ա���Ϣ��");

		try {
			System.out.println(HttpClientHelper.convertStreamToString(
					HttpClientHelper.get("http://api.weimi.cc/2/sms/send.html",
							para), "UTF-8"));

			System.out.println(HttpClientHelper.convertStreamToString(
					HttpClientHelper.post(
							"http://api.weimi.cc/2/sms/send.html", para),
					"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���Žӿڶ���������ģ����Žӿڣ��������ö�̬�����������ʺϣ���֤�롢�������ŵȡ�
	 */
	public static void sms_api2() {

		Map<String, String> para = new HashMap<String, String>();

		/**
		 * Ŀ���ֻ����룬����ԡ�,���ָ���һ���Ե������100�����룬ʾ����139********,138********
		 */
		para.put("mob", "<enter your mobiles>");

		/**
		 * ΢���˺ŵĽӿ�UID
		 */
		para.put("uid", "<enter your UID>");

		/**
		 * ΢���˺ŵĽӿ�����
		 */
		para.put("pas", "<enter your UID Pass>");

		/**
		 * �ӿڷ������ͣ�json��xml��txt��Ĭ��ֵΪtxt
		 */
		para.put("type", "json");

		/**
		 * ����ģ��cid��ͨ��΢�׺�̨�����������߿ͷ���ˡ��������úö���ǩ����ǩ���淶�� <br>
		 * 1��ģ������һ��Ҫ��ǩ����ǩ������ģ�����ݵ���ǰ�棻<br>
		 * 2��ǩ����ʽ����***����ǩ������Ϊ�����������ϣ�������������<br>
		 * 3���������ݲ�����˫ǩ����������������ֻ��һ����������<br>
		 */
		para.put("cid", "<enter your cid>");

		/**
		 * ����ģ�������<br>
		 * <br>
		 * ����ģ��ʾ����<br>
		 * ��΢�ס�������֤���ǣ�%P%��%P%��������Ч����������˲������ɺ��Ա���Ϣ��<br>
		 * <br>
		 * ��������������<br>
		 * p1��610912<br>
		 * p2��3<br>
		 * ���շ������ݣ�<br>
		 * ��΢�ס�������֤���ǣ�610912��3��������Ч����������˲������ɺ��Ա���Ϣ��
		 */
		para.put("p1", "610912");
		para.put("p2", "3");

		try {
			System.out.println(HttpClientHelper.convertStreamToString(
					HttpClientHelper.get("http://api.weimi.cc/2/sms/send.html",
							para), "UTF-8"));

			System.out.println(HttpClientHelper.convertStreamToString(
					HttpClientHelper.post(
							"http://api.weimi.cc/2/sms/send.html", para),
					"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] a) {

		// ���Զ��Žӿ�һ
		sms_api1();
		
		// ���Զ��Žӿڶ�
		sms_api2();
		
		//ע�⣺���ϲ�������ʱ��������<>������
	}

}
