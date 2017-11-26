//package com.tr.p5.hibernate;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.tr.common.hibernate.BaseService;
//import com.tr.common.hibernate.pojo.HqlQuerys;
//import com.tr.common.page.PageReq;
//import com.tr.common.page.PageRes;
//import com.tr.p5.entity.Depot;
//
//@Service
//public class DepotHibernate extends BaseService<Depot> {
//	
//	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
//    public PageRes<List<Depot>> pageList(PageReq<Depot> depot) {
//        if (depot.getData() == null) {
//        		depot.setData(new Depot());
//        }
//        HqlQuerys qr = new HqlQuerys(true)
//             .init(depot) // DISTINCT(a)
//             .setQueryString("FROM Depot a WHERE 1=1")
//             .setCountString("SELECT COUNT(a.id) FROM Depot a WHERE 1=1")
//             .setOrderAlias("a")
//             // .addParam("name", like(depot.getData().getName()), " and a.name like :name ")
//             // .addParam("delf", Delf.N, " and a.delf = :delf ")
//             // .addParam("roleId", depot.getData().getRoleId(), " and rs.id = :roleId ")
//             // .setGroup(" group by a.id ")
//             ;
//        return super.pageList(qr);
//    }
//
//}
