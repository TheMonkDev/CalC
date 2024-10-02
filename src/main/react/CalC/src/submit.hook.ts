import { useState } from "react";
import axios from "axios";

const useSubmit = () => {
  const [loading, setLoading] = useState(false);
  const onSubmit = async (expression: string): Promise<string> => {
    setLoading(true);
    try {
      const result = await axios.post(
        "http://localhost:8080/calculate",
        {
          expression: expression
        },
        {
          headers: {
            "Content-Type": "application/json"
          }
        }
      );
      if (result.status != 200) throw new Error("");
      return expression + "=" + result.data;
    } catch (error) {
      return expression + "=" + error;
    } finally {
      setLoading(false);
    }
  };
  return { loading, onSubmit };
};

export default useSubmit;
