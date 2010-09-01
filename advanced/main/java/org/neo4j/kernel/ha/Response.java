package org.neo4j.kernel.ha;

public class Response<T>
{
    private final T response;
    private final TransactionStreams transactions;

    public Response( T response, TransactionStreams transactions )
    {
        this.response = response;
        this.transactions = transactions;
    }

    public T response() throws MasterFailureException
    {
        return response;
    }

    public TransactionStreams transactions()
    {
        return transactions;
    }

    public static <R> Response<R> wrapResponseObjectOnly( R response )
    {
        return new Response<R>( response, TransactionStreams.EMPTY );
    }
}
