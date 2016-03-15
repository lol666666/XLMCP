package com.xunlei.mcp.test.cases.apple1.sniffer;

import org.junit.Test;

import com.xunlei.mcp.test.modules.base.BaseCase;
import com.xunlei.mcp.test.modules.utils.Constant;

public class SnifferGet extends BaseCase{
	@Test(summary = "获取嗅探结果", expectedResults = "返回结果格式正确", index = 1)
	public void testSnifferGet() {
		g_user.setHttpParam("productId", "51");
		g_user.setHttpParam("version", "1.0");
		g_user.setHttpParam("body", "{\"title\":\"太子妃升职记\",\"reqList\":[{\"type\":\"nsrc\",\"list\":[\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_zZF1zSqoljte43aUbBeZyPuKXPTUS3bdjTNtA2NhCn8\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_8hC_je6953ybrWxBdJmSHKhVinGUpC9dTDDsBwYwk_d271i8AwTaP1s\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IGtjCKDkK1TnrzyeCnRv0_REsRELNT-ufUZSbcDXEeNlQb_\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IGtiTNCVUB8SxokDyqRLwZQNAVTzhNDrJB9CbcYPLxBsIkXCu0WFXaAV2qBdlxmcaaknwdfn6gwCAG_1Mag2lCgSHGnV5oamg7Rwfg2Z9POIoB7-jzK37su7rsXZcNIs8sa25mS6rMaFVY4y17aZnFqU1kkJODKvCNf2h17jn5suGp89Bs_qGTCFvXJECJJvawqR8PJCP3SJindjG2O7F1RT15mDMp9ZSazb3envlhCi1oFDnGF90nMwpyy4hcrCVi9IH1PVmO97JrTDExuuIYjRLhhW\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_yNZ0DGvo6mlxP4gZQRAZj0zRTrIBTHsvZiHpspMoyzuQT2AkMk6hAFhtG5n7Wjb9a\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_y5IRWzh95qshbWxBd-vYybaNH_XHVL6vSPQpxsFwX_u0VAm7BJAu_9Ssm5n8XqGde_kxsjS\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_ypBQGbf6Y39h47aUbBjJ7HN3S8JUZK8vHKDfK\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IFR0PBn5FOnSxo9jpnPnlJdcfEFWhACbDUpOadCPQps1Gx8yj2mUm8BFDq_NoqnN8nyC-\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IGtjGAiNILDm6oIjpnLWwBdkfEVPdL8vLJ5DhxWeCv1ZZrX_c07Mp6so4g43\",\"IlPT2AEptyoA_yixCFOxXnANedT62v3IEQGG_zZF0DKrpEayxP4kHREsRDPuLGqQFoCb9nK4e2NMdiHyLD-zlsMFhPMuen9hbK\"]}]}");
		g_user.postJsonResp(Constant.SPY_GET);
	}
}
