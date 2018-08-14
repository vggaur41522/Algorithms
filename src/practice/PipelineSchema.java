package practice;

import java.util.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import practice.model.*;

public class PipelineSchema {
  
  private ObjectMapper mapper = new ObjectMapper();
  private Map<String, String> shemaType = new HashMap<>();
  
  public static void main(String[] args) throws Exception{
    // TODO Auto-generated method stub
    String jsonSchemaStr = "{\"type\":\"struct\",\"fields\":[{\"name\":\"ch_arenas\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_bill_bus_unit\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_bill_prop_flg\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_erf1a_data\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_fema_number\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_fema_reason\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_fema_status\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_fitness_ctr_flg\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_flag\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_geo_pos_x\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_geo_pos_y\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_gm_addl_email\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_iso_state_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_laundry_ctr_flg\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_loc_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_location_method\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_location_verify\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_med_facil\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_military_base\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_note_bus_unit\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_othr_amens\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_reporting_flag\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_rev_rpt_curr\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_str_loc_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_str_mrkt_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_str_tract_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"ch_university\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"corridor\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"county\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dadd1\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dadd2\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dcity\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dcntry\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"diflag\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dstate\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"dzip\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"gen_mgr\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"geo_code\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"in_city_limit\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"iso_country_2char\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"last_dttm_update\",\"type\":\"timestamp\",\"nullable\":true,\"metadata\":{}},{\"name\":\"last_dttm_update_gmt\",\"type\":\"timestamp\",\"nullable\":true,\"metadata\":{}},{\"name\":\"legal_sec_name\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"liquor\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"madd1\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"madd2\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"mcity\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"mcntry\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"mod_by\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"mstate\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"mzip\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_fbo_500ft\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_fbo_premises\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_floors\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_inpools\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_lounges\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_mtg_rms\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_outpools\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"nbr_rooms\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"project_id\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"prop_fax\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"prop_id\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"prop_open_date\",\"type\":\"timestamp\",\"nullable\":true,\"metadata\":{}},{\"name\":\"prop_phone\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"res_status\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"revocc_rpt_flag\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"sales_mgr\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"trvlagnt_comm\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}},{\"name\":\"trvlagnt_comm_pct\",\"type\":\"double\",\"nullable\":true,\"metadata\":{}},{\"name\":\"year_built\",\"type\":\"string\",\"nullable\":true,\"metadata\":{}}]}";
    PipelineSchema sProb = new PipelineSchema();
    List<String> jsonSchema  = sProb.findSchema(jsonSchemaStr);
    String csvSchemaStr = "prop_id,legal_sec_name,dadd1,dadd2,dcity,dstate,ch_iso_state_code,dzip,dcntry,iso_country_2char,madd1,madd2,mcity,mstate,mzip,mcntry,prop_phone,prop_fax,gen_mgr,ch_gm_addl_email,sales_mgr,nbr_rooms,nbr_floors,nbr_mtg_rms,nbr_lounges,liquor,corridor,nbr_fbo_premises,nbr_fbo_500ft,nbr_inpools,nbr_outpools,diflag,prop_open_date,year_built,res_status,trvlagnt_comm,trvlagnt_comm_pct,geo_code,county,in_city_limit,mod_by,last_dttm_update,last_dttm_update_gmt,ch_loc_code,ch_geo_pos_x,ch_geo_pos_y,ch_location_method,ch_location_verify,ch_str_mrkt_code,ch_str_tract_code,ch_bill_prop_flg,ch_bill_bus_unit,ch_note_bus_unit,ch_rev_rpt_curr,ch_flag,ch_fema_status,ch_fema_number,ch_fema_reason,revocc_rpt_flag,project_id,ch_str_loc_code,ch_erf1a_data,ch_reporting_flag,ch_fitness_ctr_flg,ch_laundry_ctr_flg,ch_military_base,ch_med_facil,ch_arenas,ch_university,ch_othr_amens";
    List<String> csvSchema = sProb.csvSchemaProcess(csvSchemaStr);
  }

  private List<String> csvSchemaProcess(String csvSchemaStr) {
    System.out.println(csvSchemaStr);
    String[] strArr = csvSchemaStr.split(",");
    List<String> result = Arrays.asList(strArr);
    System.out.println("\n------------\nCSV SCHEMA->"+result);
    result.forEach(i -> System.out.println(i + "\t" + shemaType.get(i)));
    return result;
  }

  private List<String> findSchema(String jsonSchemaStr) throws Exception{
    List<String> result = new ArrayList<>();
    JsonPipelineRequest request = mapper.readValue(jsonSchemaStr, JsonPipelineRequest.class);
    System.out.println(request);
    result = request.getFields().stream().map(field -> field.getName() + "\t" + field.getType())
        .sorted()
        .collect(Collectors.toList());
    
    shemaType = request.getFields().stream().collect(Collectors.toMap(Field::getName, Field::getType));
    
    System.out.println("\n------------\nJSON SCHEMA->"+shemaType);
    result.forEach(i -> System.out.println(i));
    
    return result;
  }

}