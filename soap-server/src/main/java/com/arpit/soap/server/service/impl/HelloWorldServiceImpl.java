package com.arpit.soap.server.service.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(serviceName = "DotsService", targetNamespace = "http://example/")
public class HelloWorldServiceImpl
{
	private static List<EntityWithDots> data = new ArrayList<>();

	static {
//		EntityWithDots entity = new EntityWithDots();
		for (int i = 1; i <= 100; i++)
		{
			EntityWithDots entity = new EntityWithDots();
			Long id = new Long(i);
			entity.setId(id);
			if (i%2==0) {
				entity.setYourField("FIELDS"+i);
			} else {
				entity.setYourField("VALUE"+i);
			}

			if (i%2==0) {
				entity.setFilter001("GABRIEL"+i);
			} else {
				entity.setFilter001("PASSINHO VITÃO"+i);
			}

			data.add(entity);

		}

	}

	@WebMethod
	public List<EntityWithDots> list(@WebParam(name = "pageXYZ") String pageX,
									 @WebParam(name = "quantity") String quantity,
									 @WebParam(name = "idX") Integer idX,
									 @WebParam(name = "orderByX") OrderBy orderByX,
									 @WebParam(name = "filtro001") EntityWithDots filter001
	)
	{
		if (idX != null)
		{
			return data.stream().filter(m -> m.getId().equals(idX)).collect(Collectors.toList());
		}

		List<EntityWithDots> mailsCopy = new ArrayList<>(data);

		/*
		if(orderBy != null)
		{
			OrderByTypes order = OrderByTypes.valueOf(orderBy.getOrder());

			mailsCopy.sort((c1, c2) -> {
				try
				{
					Field f = Mail.class.getDeclaredField(orderBy.getField());
					f.setAccessible(true);
					Object v1 = f.get(c1);
					Object v2 = f.get(c2);

					if (v1 instanceof Comparable && v2 instanceof Comparable)
					{
						return order == asc ? ((Comparable) v1).compareTo(v2)
								: ((Comparable) v2).compareTo(v1);
					}

					if (v1 == null && v2 != null)
					{
						return order == asc ? -1 : 1;
					}

					if (v2 == null && v1 != null)
					{
						return order == asc ? 1 : -1;
					}
					return 0;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				return 0;
			});
		}
		*/


		return Util.doPagination(pageX, quantity, mailsCopy);
	}

/*
	private static List<OperationSoap> dataOperation = new ArrayList<>();

	static {

		for (int i = 1; i <= 100; i++)
		{
			OperationSoap operation = new OperationSoap();
			operation.setOperationId(i);
			if (i%2==0) {
				operation.setName("OPERATION"+i);
				operation.setTypeOperation("TIPO II");
			} else {
				operation.setName("TEST"+i);
				operation.setTypeOperation("TIPO I");
			}

			dataOperation.add(operation);

		}

	}

	@WebMethod
	public List<OperationSoap> operationSoap(@WebParam(name = "page") String page,
									 @WebParam(name = "quantity") String quantity,
									 @WebParam(name = "id") Integer id)
	{


		List<OperationSoap> data = new ArrayList<>(dataOperation);

		if (id != null)
		{
//			return data.stream().filter(m -> m.getId().equals(id)).collect(Collectors.toList());
		}

		return Util.doPagination(page, quantity, data);
	}

 */
}
