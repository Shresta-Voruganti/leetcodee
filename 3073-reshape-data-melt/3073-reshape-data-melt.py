import pandas as pd

def meltTable(report: pd.DataFrame) -> pd.DataFrame:
    df = report.melt(id_vars = 'product', var_name = 'quarter', value_name = 'sales')
    return df