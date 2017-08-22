package com.roachfu.solar.app.filter;

import com.alibaba.fastjson.JSONObject;
import com.roachfu.solar.client.base.entity.APIResponse;
import com.roachfu.solar.client.base.entity.Meta;
import com.roachfu.solar.client.base.eums.ErrorEnum;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * API 认证过滤器
 *
 * @author roach
 * @date 21/08/2017 21:53
 */
public class APIAuthenticationFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIAuthenticationFilter.class);

    /**
     * APP key
     */
    private static final String APP_KEY = "sJ2KZooZdaQrG3FOqHHCbpjOCIC3dBtV";
    /**
     * 安全 key
     */
    private static final String APP_SECRET = "JkIra5lFvPm5BOP78ShrZsVMMKgX3jny";

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 初始化filter数据
    }

    @Override
    public void doFilter(ServletRequest servletReqeust, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletReqeust;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

		/* (1). 判断app-key是否正确 */
        String appKey = request.getHeader("App-Key");

        if (!APP_KEY.equals(appKey)) {
            doError(ErrorEnum.APP_KEY_ERROR, response);
            return;
        }

		/* (2). app-key验证成功, 验证签名 */
        String nonce = request.getHeader("App-Nonce");
        String timestamp = request.getHeader("App-Timestamp");
        String signature = request.getHeader("App-Signature");

        StringBuilder data = new StringBuilder(APP_SECRET).append(nonce).append(timestamp);
        String localSign = DigestUtils.sha1Hex(data.toString());

        LOGGER.info("nonce is [{}], timestamp is[{}], signature is [{}], local sign is [{}]", nonce, timestamp, signature, localSign);
        if (!localSign.equals(signature)) {
            LOGGER.error("签名有误");
            doError(ErrorEnum.SIGNATURE_ERROR, response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 销毁filter
    }

    public void doError(ErrorEnum errorEnum, HttpServletResponse response) throws IOException {
        Meta meta = new Meta(errorEnum);
        APIResponse result = new APIResponse(meta, new Object());
        PrintWriter out = response.getWriter();
        out.println(JSONObject.toJSONString(result));
        out.close();
    }

}
