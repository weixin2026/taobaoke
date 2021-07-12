//package com.jjld.coupon.service.external;
//
//import com.jjld.coupon.config.FeignConfig;
//import com.taobao.api.response.TbkTpwdCreateResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author SongFei
// * @date 2019/12/23 17:33
// */
//@FeignClient(name = "tbk-taobaoapi", configuration = FeignConfig.class/*, fallback = TbkServiceFallback.class*/)
//public interface TbkService {
//
//    /**
//     * 生成淘口令
//     *
//     * @param itemTitle 弹窗标题，不可有群号等敏感信息
//     * @param itemPic   弹窗图片
//     * @param couponUrl 弹窗跳转链接
//     * @return 淘口令
//     */
//    @RequestMapping(value = "/taoBao/getCreateTkl", method = RequestMethod.GET)
//    TbkTpwdCreateResponse getCreateTkl(@RequestParam("itemTitle") String itemTitle,
//                                       @RequestParam("itemPic") String itemPic,
//                                       @RequestParam("couponUrl") String couponUrl);
//
//}
