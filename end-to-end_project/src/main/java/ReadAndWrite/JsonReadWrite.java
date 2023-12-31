package ReadAndWrite;

import EquationClass.MathEquation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonReadWrite
{
    public static List<MathEquation> readFromJSONFile(String filePath)
    {
        List<MathEquation> equations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
            {
                content.append(line);
            }

            JSONArray jsonArray = new JSONArray(content.toString());

            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String equation = jsonObject.getString("equation");
                String variables = jsonObject.getString("variables");
                double result = jsonObject.getDouble("result");
                equations.add(new MathEquation(equation, variables, result));
            }

            return equations;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
        catch (JSONException e)
        {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static void writeToJSONFile(List<MathEquation> equations, String filePath)
    {
        JSONArray jsonArray = new JSONArray();

        for (MathEquation equation : equations)
        {
            JSONObject equationJson = new JSONObject();
            equationJson.put("equation", equation.getEquation());
            equationJson.put("variables", equation.getVariables());
            equationJson.put("result", equation.getResult());
            jsonArray.put(equationJson);
        }

        try (FileWriter file = new FileWriter(filePath))
        {
            file.write(jsonArray.toString(4));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
